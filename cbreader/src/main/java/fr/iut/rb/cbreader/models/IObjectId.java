package fr.iut.rb.cbreader.models;

import org.bson.types.ObjectId;

public interface IObjectId {
    /**
     * @return the ID
     */
    public ObjectId getId();
    /**
     * @param id
     */
    public void setId(ObjectId id);
}
