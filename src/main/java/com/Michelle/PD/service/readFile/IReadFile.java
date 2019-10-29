package com.Michelle.PD.service.readFile;

import com.Michelle.PD.vo.ReadFileRequest;
import com.Michelle.PD.vo.ReadFileResponse;

import java.io.IOException;

public interface IReadFile {
    
    ReadFileResponse readFile(ReadFileRequest readFileRequest) throws IOException;
}
