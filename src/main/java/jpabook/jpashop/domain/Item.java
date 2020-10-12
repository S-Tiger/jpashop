package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE) //상속받은 Entity들이 한테이블로 생성되는데
//InheritanceType.JOINED를 작성하면 조인 테이블로 생성 //SINGLE_TABLE로 작성하면 싱글테이블로 작성 싱글테이블이 성능은 더 좋다
@DiscriminatorColumn(name = "dtype") //조인한 테이블들의 타입을 넣기위해 필요한 어노테이션 디폴트이름은 DTYPE //단일테이블전략에선 작성안해도 자동으로 추가
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();


    public void removeStock(int count){
        this.stockQuantity = count;
    }

    public void addStock(int count){
      this.stockQuantity += count;
    }
}
