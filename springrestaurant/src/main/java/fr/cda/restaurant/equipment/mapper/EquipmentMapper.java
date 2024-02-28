package fr.cda.restaurant.equipment.mapper;

import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.equipment.dto.EquipmentCompletDto;
import fr.cda.restaurant.equipment.dto.EquipmentReduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EquipmentMapper {
    public fr.cda.restaurant.equipment.mapper.EquipmentMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.equipment.mapper.EquipmentMapper.class);

    public EquipmentCompletDto toEquipmentCompletDto(List<Equipment> equipment);
    public EquipmentReduitDto toEquipmentReduitDto(List<Equipment> equipment);
}
