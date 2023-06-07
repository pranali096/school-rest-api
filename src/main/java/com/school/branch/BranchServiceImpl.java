package com.school.branch;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.util.Util;

@Service
public class BranchServiceImpl implements BranchService {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());



	@Autowired
	BranchRepository branchrepository;

	@Autowired
	Util util;

	@Autowired
	BranchBuilder branchBuileder;

	@Override
	public String addBranch(BranchRequestDto branch) {
		if (!branch.getPassword().equals(branch.getConfirmpassword())) {
	        return util.objectMapperError("Password and confirmPassword do not match");
	    }else {
		Branch br = BranchBuilder.bBuilder().convertToBranchrequestdto(branch);
		Branch brc = branchrepository.save(br);
		BranchResposnceDto chdt = BranchBuilder.bBuilder().counvrtToBranch(brc);
	
		LOG.info("Save Branch");
		return util.objectMapperSuccess(chdt, "Save Branch");
		    }
	}
	
	
	
	
	@Override
	public ResponseEntity<String> changePassword(ChangePasswordData pdata) {

		String password = pdata.getComfirmPasswor();
		String confirmPassword = pdata.getComfirmPasswor();
		String id = pdata.getId();

		if (password.isEmpty()) {
			return ResponseEntity.badRequest().body("Current password is required");
		}

		if (!password.equals(confirmPassword)) {
			return ResponseEntity.badRequest().body("New password and confirm password do not match");
		}
		if (id.isEmpty()) {
			return ResponseEntity.badRequest().body(" ID is required");
		}

		return ResponseEntity.ok("Password changed successfully");

	}

	@Override
	public String getAllBranchesByPegination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest page = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder, sortBy));
		if (isPagination > 0) {
			Page<Branch> bpage = branchrepository.findAll(page);
			Page<BranchResposnceDto> bpagedto = bpage.map(new Function<Branch, BranchResposnceDto>() {

				@Override
				public BranchResposnceDto apply(Branch t) {
					return BranchBuilder.bBuilder().counvrtToBranch(t);
				}
			});
			LOG.info(" list of All Branches");
			return util.objectMapperSuccess(bpagedto, " list of All Bramches");
		} else {
			List<Branch> blist = (List<Branch>) branchrepository.findAll();
			LOG.info("Branch list");
			return util.objectMapperSuccess(blist, "Branch List");
		}
	}

	@Override
	public String getBranchById(Long id) {
		Optional<Branch> bid = branchrepository.findById(id);
		if (bid.isPresent()) {
			Branch bn = bid.get();
			BranchResposnceDto bdto = BranchBuilder.bBuilder().counvrtToBranch(bn);
			LOG.info("Get Branch By id");
			return util.objectMapperSuccess(bdto, "Get Branch By id");
		} else {
			return util.objectMapperError(bid, "Not found branch");
		}

	}

	@Override
	public String deleteByid(Long bid) {
		Optional<Branch> bn = branchrepository.findById(bid);
		if (bn.isPresent()) {
			branchrepository.deleteById(bid);
			LOG.info("Delete branch succusesfully");
			return util.objectMapperSuccess(bn, "Delete Branch succusesfully");
		} else {
			return util.objectMapperError(bn, "not delete branch succusesfully");
		}

	}



	
	@Override
	public String updateByid(BranchDto bdto) {
		Optional<Branch> branchop = branchrepository.findById(bdto.getId());
		if (branchop.isPresent()) {
			Branch brch = BranchBuilder.bBuilder().convertToBranchDto(bdto);
			brch.setPassword(branchop.get().getPassword());
			brch.setConfirmPassword(branchop.get().getConfirmPassword());
			Branch brn = branchrepository.save(brch);
			BranchResposnceDto bcdto = BranchBuilder.bBuilder().counvrtToBranch(brn);
			LOG.info("Update Branch");
			return util.objectMapperSuccess(bcdto, "Update Branch");

		} else {

			LOG.info("The given branch not found.");
			return util.objectMapperError("The given branch not found.");
		}

	}


}
