package jpabook.jpashop.controller

import jpabook.jpashop.service.MemberService
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.awt.PageAttributes

@Controller
class MemberController
    (
    val memberService: MemberService,


            )
{
    @GetMapping("/members/new", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
        fun createForm(model:Model):String {
            model.addAttribute("memberForm", MemberForm())
        return "members/createMemberForm"
        }
}