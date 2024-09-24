package finalprjwebtoonservicev.infra;

import finalprjwebtoonservicev.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/webtoons")
@Transactional
public class WebtoonController {

    @Autowired
    WebtoonRepository webtoonRepository;
}
//>>> Clean Arch / Inbound Adaptor
