package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {
    @Autowired
    CookingRepository cookingRepository;



    @RequestMapping(value = "cookings/{id}/acceptorreject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking acceptOrReject(@PathVariable(value = "id") Long id, @RequestBody AcceptOrRejectCommand acceptOrRejectCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/acceptOrReject  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.acceptOrReject(acceptOrRejectCommand);
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    




}
