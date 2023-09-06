package jpabook.jpashop.web;
/*
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    /**상품 등록
    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm form) {

        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }*/


    /**상품 목록
    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }*/


    /**상품 수정 폼
    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book item = (Book) itemService.findOne(itemId);     //수정할 상품을 조회

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);   //조회 결과를 모델 객체에 담아서
        return "items/updateItemForm";      //뷰에 전달
    }*/

    /**상품 수정
    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {
        //컨트롤러에 파라미터로 넘어온 item 엔티티 인스턴스는 현재 준영속 상태
        // 따라서 (영속성 컨텍스트의 지원을 받을 수 없고) 데이터를 수정해도 변경 감지 기능은 동작X
        Book book = new Book();

        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        //Book 객체는 이미 DB에 한번 저장되어서 식별자가 존재 ->준영속 엔티티
        //(이렇게 임의로 만들어낸 엔티티도 기존 식별자를 가지고 있으면 준영속 엔티티)

        return "redirect:/items";
    }   컨트롤러에서 어설프게 엔티티를 생성하지 않는다   */

    /**엔티티를 변경할 때는 항상 변경 감지를 사용!
    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {
        //트랜잭션이 있는 서비스 계층에 식별자( id )와 변경할 데이터를 명확하게 전달
        itemService.updateItem(form.getId(), form.getName(), form.getPrice());
        return "redirect:/items";
    }

}*/
