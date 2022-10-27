package com.office.iservice;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.office.entity.Entity1;

public interface IOfficeService {

	public  List<Entity1> alldata();
	public  String deletedata(int empid);
    public  Optional<Entity1> insertdata(Entity1 office);
    public  Optional<Entity1> onedata(int id);
    public  Optional<Entity1> updatedata(Entity1 entity);

}
