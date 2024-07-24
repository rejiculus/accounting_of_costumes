package com.accounting_of_costumes.api.Image.DTO;

import com.accounting_of_costumes.usercases.Image.DTO.IUpdateImageData;

public record UpdateImageData(Long id, String source, Long itemId) implements IUpdateImageData {
}
