package edu.gdou.gym_java.mapper;

import edu.gdou.gym_java.entity.model.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ylhy
 * @since 2022-05-31
 */
@Mapper
public interface FieldMapper extends BaseMapper<Field> {

    List<Field> queryFieldByType(Integer tid);

    Field queryFieldById(Integer fid);

    List<FieldDate> queryDateByField(Integer fid, java.sql.Date date, int inode);


    void addDate(FieldDate fieldDate);

    List<TimeArrange> queryTimeByFdId(Integer fdid);

    void addTime(TimeArrange timeArrange);


    List<FieldType> queryType();

    FieldType queryTypeById(Integer tid);

    boolean addField(Field field);

    List<Field> fillFieldInType(Integer tid);

    boolean updateField(Field field);

    boolean updateStatus(Integer time_id, String status);

    Boolean addCheck(FieldCheck fieldCheck);

    TimeArrange queryTimeById(Integer timeId);

    Boolean addOrderItem(OrderItem orderItem);

    FieldCheck queryCheckById(Integer id);

    Boolean updateCheck(FieldCheck fieldCheck);

    List<OrderItem> queryOrderItemByFcid(Integer id);


    List<FieldCheck> queryCheck();

    List<FieldCheck> queryCheckByUid(Integer uid);

    Boolean updateCheckById(FieldCheck fieldCheck);

//  Boolean cancelCheckById(FieldCheck fieldCheck);
}
