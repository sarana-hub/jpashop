package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**상품 서비스*/

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }


    /** 변경 감지 기능 사용*/
    /*@Transactional
    public Item updateItem(Long itemId, Book param){    //param: 파리미터로 넘어온 준영속 상태의 엔티티
        Item findItem=itemRepository.findOne(itemId);   //같은 엔티티를 조회

        findItem.setPrice(param.getPrice());    //데이터를 수정
        findItem.setName(param.getName());
        findItem.setStockQuantity(param.getStockQuantity());
        return findItem;
    }*/


    /*
     * 영속성 컨텍스트가 자동 변경
     */
    /*트랜잭션 안에서 엔티티를 다시 조회, 변경할 값 선택
    트랜잭션 커밋 시점에 변경 감지(Dirty Checking) 동작해서 데이터베이스에 UPDATE SQL 실행*/
    @Transactional
    public void updateItem(Long itemId, String name, int price) {
        //트랜잭션이 있는 서비스 계층에 식별자( id )와 변경할 데이터를 명확하게 전달 (파라미터 or dto)

        //트랜잭션이 있는 서비스 계층에서 영속 상태의 엔티티를 조회하고
        Item findItem = itemRepository.findOne(itemId);

        //엔티티의 데이터를 직접 변경
        findItem.setName(name);
        findItem.setPrice(price);
    }
}
