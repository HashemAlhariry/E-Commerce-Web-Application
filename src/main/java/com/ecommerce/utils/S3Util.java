package com.ecommerce.utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.UUID;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;

public class S3Util {

    LocalDateTime localDateTime;
    private static final String BUCKET = "amazonya";

    public static String uploadFile(String fileName, InputStream inputStream)
            throws S3Exception, AwsServiceException, SdkClientException, IOException {
        String imageLink;
        java.util.List<String> links = new ArrayList<>();
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("AKIAZDTDKXCBWWIZ4LMN", "a6nMfyuK4+dBtlf02TE7F3UYgyoewlsFpIc7T/yO");
        Region region = Region.EU_CENTRAL_1;
        S3Client client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .region(region)
                .build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .acl("public-read")
                .build();
        client.putObject(request,
                RequestBody.fromInputStream(inputStream, inputStream.available()));

        S3Waiter waiter = client.waiter();
        HeadObjectRequest waitRequest = HeadObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        WaiterResponse<HeadObjectResponse> waitResponse = waiter.waitUntilObjectExists(waitRequest);
        waitResponse.matched().response().ifPresent(response -> {
            // run custom logics when the file exists on S3
            // get Image Link
            DateTimeFormatter format = new DateTimeFormatterBuilder().appendLiteral("yyyy-mm-dd-hh-mm-ssss").toFormatter();
            links.add(CommonString.BUCKET_LINK+UUID.randomUUID()+fileName); //add categroy to be folder

        });
        if (links.get(0)!= null){
            return links.get(0);
        }else{
            return "default image link"; // rememberrrrrr //TODO
        }
    }



}
