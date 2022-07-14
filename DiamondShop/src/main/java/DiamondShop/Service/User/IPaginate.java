package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.PaginateDto;

@Service
public interface IPaginate {
	public PaginateDto getInfoPaginate(int totalData, int limit, int currentPage);
}
