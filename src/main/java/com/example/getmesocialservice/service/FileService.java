package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


//upload file on amazon S3 bucket.
@Service
public class FileService {
    public boolean upload(MultipartFile file) {

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA55G3R4ZU356B2QXW", "olvqMcuerfqzC3Qvl3V8HwErxYwAddxbYKwspCd/");


        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("backend-spring22", file.getOriginalFilename(), file.getInputStream(), metadata);
            return true;
        } catch (AmazonServiceException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA55G3R4ZU356B2QXW", "olvqMcuerfqzC3Qvl3V8HwErxYwAddxbYKwspCd/");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
        return  s3.getObject("backend-spring22", key);
    }


    public void deleteFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA55G3R4ZU356B2QXW", "olvqMcuerfqzC3Qvl3V8HwErxYwAddxbYKwspCd/");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
        s3.deleteObject("backend-spring22", key);
    }




}