package edu.gdou.gym_java.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.gdou.gym_java.entity.model.Equipment;
import edu.gdou.gym_java.mapper.EquipmentMapper;
import edu.gdou.gym_java.service.*;
import edu.gdou.gym_java.service.cm.CompetitionEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lzh
 * @since 2022-06-02
 */

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {
    @Autowired
    private FixEquipmentService fixEquipmentService;
    @Autowired
    private CompetitionEquipmentService compositionEquipmentService;
    @Override
    public List<Equipment> queryEquipment(String name, String types, Integer number) {
        return getBaseMapper().queryEquipment(name,types,number);
    }

    @Override
    public Boolean addEquipment(Equipment equipment) {
        int insert = getBaseMapper().insert(equipment);
        return insert==1;
    }

    @Override
    public Integer availableEquipmentCount(Integer eid) {
        Integer compositionCount = compositionEquipmentService.queryCompositionEquipmentCountByEid(eid);
        Equipment equipment = getBaseMapper().selectById(eid);
        return equipment.getNumber()-compositionCount;
    }

    @Override
    public Equipment queryEquipmentByEid(Integer eid) {
        return getBaseMapper().selectById(eid);
    }

    @Override
    public Boolean updateEquipmentCount(Equipment equipment) {
        getBaseMapper().updateById(equipment);
        return  getBaseMapper().updateById(equipment)==1;
    }
}
