package com.accounting_of_costumes.api.Image.DTO;

import com.accounting_of_costumes.usercases.Image.DTO.ICreateImageData;

public record CreateImageData(String source, Long itemId) implements ICreateImageData {
}
