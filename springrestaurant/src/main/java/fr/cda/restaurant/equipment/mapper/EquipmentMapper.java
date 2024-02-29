package fr.cda.restaurant.equipment.mapper;

import fr.cda.restaurant.client.Client;
import fr.cda.restaurant.client.dto.ClientCompletDto;
import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.equipment.dto.EquipmentCompletDto;
import fr.cda.restaurant.equipment.dto.EquipmentReduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    public fr.cda.restaurant.equipment.mapper.EquipmentMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.equipment.mapper.EquipmentMapper.class);

    public EquipmentCompletDto toEquipmentComplet(Equipment equipment);
    public List<EquipmentCompletDto> toEquipmentComplet (List<Equipment> equipments);

    public EquipmentReduitDto toEquipmentReduit(Equipment equipment);
    public List<EquipmentReduitDto> toEquipmentReduit (List<Equipment> equipments);
}
