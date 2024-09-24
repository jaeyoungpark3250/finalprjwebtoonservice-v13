package finalprjwebtoonservicev.infra;

import finalprjwebtoonservicev.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class WebtoonHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Webtoon>> {

    @Override
    public EntityModel<Webtoon> process(EntityModel<Webtoon> model) {
        return model;
    }
}
