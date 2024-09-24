package finalprjwebtoonservicev.infra;
import finalprjwebtoonservicev.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/purchases")
@Transactional
public class PurchaseController {
    @Autowired
    PurchaseRepository purchaseRepository;

    @RequestMapping(value = "/purchases/buywebtoon",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Purchase buyWebtoon(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /purchase/buyWebtoon  called #####");
            Purchase purchase = new Purchase();
            purchase.buyWebtoon();
            purchaseRepository.save(purchase);
            return purchase;
    }
}
//>>> Clean Arch / Inbound Adaptor
