package some_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SomeCode {
    public static void main(String[] args) {


    }
}

// Микросервис чеков высоконагруженного маркетплейса, десятки тысяч заказов в сутки.
// Основная функция микросервиса - отправка чеков в налоговую (во внешний независимый сервис)
// Инфраструктура - Kubernetes 8 подов (реплик), высоконагруженный.
// TaxClient - клиент налоговой (feign) - timeout = 60 секунд (не наш, не можем повлиять)
@Service
@AllArgsConstructor
public class SomeServiceImpl implements SomeService {
    private final TaxClient taxClient;
    private final ReceiptDao receiptDao;
    private final SomeService self; //циклическая зависимость

    //java dok?
    @Override
    @Transactional
    @Scheduled(cron = "${cron.expression}")  // "30 30 * * *" //лучше сразу в крон написать, почему таймаут большой?
    public void processJobRunning() {
        List<Receipt> receipts = self.getRefundReceipts();

        for (Receipt receipt : receipts){
            receipt.setProcessed(true);
            receiptDao.save(receipt); //
            taxClient.sendReceipt(receipt); //а если ошибки? обработать и вынести из под Transactional
        }
    }

    @Transactional(readOnly = true) // зачем? новая транзакция не будет создана
    public List<Receipt> getRefundReceipts() {
        return receiptDao.findAllBySourceAndProcessedFalse(ReceiptSource.REFUND); // select * from receipt where source = 'REFUND' and processed = false;
    }
}

// граница класса ----
public interface ReceiptDao extends JpaRepository<Receipt, Long> {
    List<Receipt> findAllBySourceAndProcessedFalse(ReceiptSource source);
}

//ниже этой строки - все корректно - enum, dto, entity - только для наглядности
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean processed;
    private String sum;
    private ReceiptSource source;
}

@Data
@NoArgsConstructor
public class ReceiptDto {
    private Long id;
    private String sum;
    private ReceiptSource source;
}

public enum ReceiptSource {
    DISCOUNT,
    SELL,
    REFUND
}

