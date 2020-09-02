package Exchange;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Exchange_table")
public class Exchange {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long exchangeId;
    private Long ownerId;
    private String userName;
    private String exchangeDate;

    @PostUpdate
    public void onPostUpdate(){
        ExchangeConfirmed exchangeConfirmed = new ExchangeConfirmed();
        BeanUtils.copyProperties(this, exchangeConfirmed);
        exchangeConfirmed.publishAfterCommit();


    }


    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }




}
