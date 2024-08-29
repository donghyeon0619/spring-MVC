package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {

        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    /**
     * @Controller이고 String을 반환하는 경우
     * - @ResponseBody가 없으면 response/hello로 뷰 리졸버가 실행되어서 뷰를 찾고, 렌더링 한다.
     * - @ResponseBody가 있으면 뷰 리졸버를 실행하지 않고 HTTP 메시지 바디가 직접 response/hello라는 문자가 입력된다.
     */
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {

        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    // 이방식은 명시성이 떨어지므로 별로 권장되지않음, 이런 방식이 있다만 알고만 있어도 될듯
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }

}
