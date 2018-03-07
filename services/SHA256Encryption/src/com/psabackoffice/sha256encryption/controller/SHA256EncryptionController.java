/**
 * This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.psabackoffice.sha256encryption.controller;

import com.psabackoffice.sha256encryption.SHA256Encryption;
import java.lang.String;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/sHA256Encryption", produces = { "application/json", "application/xml" })
public class SHA256EncryptionController {

    @Autowired
    private SHA256Encryption sHA256Encryption;

    @RequestMapping(value = "/sha2", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String sha2(@RequestParam(value = "inText", required = false) String inText) {
        return sHA256Encryption.sha2(inText);
    }
}
