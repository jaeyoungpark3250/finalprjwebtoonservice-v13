package finalprjwebtoonservicev.infra;

import finalprjwebtoonservicev.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PointerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Pointer>> {

    @Override
    public EntityModel<Pointer> process(EntityModel<Pointer> model) {
        return model;
    }
}
