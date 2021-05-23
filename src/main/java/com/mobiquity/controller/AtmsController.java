package com.mobiquity.controller;

import com.mobiquity.dto.AtmsInfo;
import com.mobiquity.exception.EntityNotFoundException;
import com.mobiquity.exception.RawJsonParseException;
import com.mobiquity.service.AtmsService;
import com.mobiquity.utility.MessageConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atms")
@Api(value = "Atms Api")
public class AtmsController {

    @Autowired
    AtmsService AtmsService;

    /**
     * @return
     */
    @GetMapping(value = "/all")
    @ApiOperation(value = "Get all atms details", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MessageConstant.SUCCESS_MESSAGE),
            @ApiResponse(code = 401, message = MessageConstant.UN_AUTHORIZE_MESSAGE),
            @ApiResponse(code = 403, message = MessageConstant.FORBIDDEN_MESSAGE),
            @ApiResponse(code = 404, message = MessageConstant.NOT_FOUND_MESSAGE),
            @ApiResponse(code = 500, message = MessageConstant.INTERNAL_SERVER_MESSAGE)
    }
    )
    public ResponseEntity<List<AtmsInfo>> getAllAtms() throws RawJsonParseException {
        return new ResponseEntity<>(AtmsService.getAllAtms(), HttpStatus.OK);
    }

    /**
     * @param city
     * @return
     */
    @GetMapping("/getbycity/{city}")
    @ApiOperation(value = "Get atms details based on city", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MessageConstant.SUCCESS_MESSAGE),
            @ApiResponse(code = 401, message = MessageConstant.UN_AUTHORIZE_MESSAGE),
            @ApiResponse(code = 403, message = MessageConstant.FORBIDDEN_MESSAGE),
            @ApiResponse(code = 404, message = MessageConstant.NOT_FOUND_MESSAGE),
            @ApiResponse(code = 500, message = MessageConstant.INTERNAL_SERVER_MESSAGE)
    }
    )
    public ResponseEntity<List<AtmsInfo>> getAtmsByCity(@PathVariable("city") final String city) throws EntityNotFoundException, RawJsonParseException {
        return new ResponseEntity<>(AtmsService.getAtmsByCity(city), HttpStatus.OK);
    }

}
