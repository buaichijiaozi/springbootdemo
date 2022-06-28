package com.dz.springboard.mapper;

import com.dz.springboard.entity.Address;
import com.dz.springboard.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AddressMapper {

    Integer insert(Address address);
    Integer countByUid(Integer uid);
    Address ByUid(Integer uid);

    List<Address> findByUid(Integer uid);

    Address findByAid(Integer aid);

    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);


    Integer updateDefaultByUid(@Param("uid") Integer uid,
                                @Param("modifiedUser") String modifiedUser,
                                 @Param("modifiedTime") Date modifiedTime);


    Integer deleteByAid(Integer aid);

    Address findLastModified(Integer uid);


}
