package com.example.client1.repository;

import com.example.client1.DTO.iframeDTO;

/*
Create a repository Interface(iframeRepository) so the controller
 can call repository methods. If there was any change in database technology
 there is no need to change the interface methods. Just change the repository layer
*/
public interface IframeRepository {
    public Object findAllIframes();
    public iframeDTO findIframe(String iframeName);
    public boolean updateIframe(String frameName,String newLink);
}
