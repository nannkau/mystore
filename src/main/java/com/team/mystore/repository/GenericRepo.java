package com.team.mystore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface GenericRepo<T> extends CrudRepository<T,Long> {


}
