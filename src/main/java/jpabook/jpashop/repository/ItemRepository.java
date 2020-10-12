package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(final Item item) {
        if (item.getId() == null) {
            em.persist(item);  // 새로 생성한 객체, 신규 영속화
        } else {
            em.merge(item);  // 업데이트와 비슷
        }
    }

    public Item findOne(final Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}