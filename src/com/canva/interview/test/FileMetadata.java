package com.canva.interview.test;

public class FileMetadata {

    private String fileName;

    private long uploadDate;

    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void setUploadDate(long uploadDate){
        this.uploadDate = uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public long getUploadDate() {
        return uploadDate;
    }
}
