package finalprjwebtoonservicev.infra;

import finalprjwebtoonservicev.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PurchaseHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Purchase>> {

    @Override
    public EntityModel<Purchase> process(EntityModel<Purchase> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//buywebtoon")
                .withRel("/buywebtoon")
        );

        return model;
    }
}
