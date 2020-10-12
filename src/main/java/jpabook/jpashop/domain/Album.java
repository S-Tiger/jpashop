package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //조인대상테이블(부모테이블)에 DTYPE에 값이 기본은 Entity명이지만 바꿔야할 경우 사용하는 어노테이션
@Getter @Setter
public class Album  extends Item{

    private String artist;
    private String etc;

}
