package com.mukul.sf_movies.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.mukul.sf_movies.entities.SfMovieEntity;

@XmlRootElement(name="")
@XmlSeeAlso({SfMovieEntity.class})
public class Page<E> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5565531107940802716L;
	private  int pageNumber;
    private  int pagesAvailable;
    private List<E> pageItems = new ArrayList<E>();

    public Page() {
		// TODO Auto-generated constructor stub
	}
   
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }

    public void setPageItems(List<E> pageItems) {
        this.pageItems = pageItems;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public List<E> getPageItems() {
        return pageItems;
    }
}