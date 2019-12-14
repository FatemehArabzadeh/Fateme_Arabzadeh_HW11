package com.example.myannuallytasks.model;

import com.example.myannuallytasks.greendao.UuidConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import java.util.UUID;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
@Entity(nameInDb = "Person")
public class Person {
    @Id private Long id;
    @ToMany(referencedJoinProperty = "personId")
    private List<Task> tasks;

    @Property(nameInDb = "uuid")
    @Index(unique = true)
    @Convert(converter = UuidConverter.class, columnType = String.class)
    private UUID mID;
    private String mUser;
    private String mPass;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 778611619)
    private transient PersonDao myDao;


    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public UUID getmID() {
        return mID;
    }

    public String getmUser() {
        return mUser;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getMID() {
        return this.mID;
    }

    public void setMID(UUID mID) {
        this.mID = mID;
    }

    public String getMUser() {
        return this.mUser;
    }

    public void setMUser(String mUser) {
        this.mUser = mUser;
    }

    public String getMPass() {
        return this.mPass;
    }

    public void setMPass(String mPass) {
        this.mPass = mPass;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1026991924)
    public List<Task> getTasks() {
        if (tasks == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskDao targetDao = daoSession.getTaskDao();
            List<Task> tasksNew = targetDao._queryPerson_Tasks(id);
            synchronized (this) {
                if (tasks == null) {
                    tasks = tasksNew;
                }
            }
        }
        return tasks;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 668181820)
    public synchronized void resetTasks() {
        tasks = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2056799268)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonDao() : null;
    }

    public Person(String mUser, String mPass) {
        this.mID = UUID.randomUUID();
        this.mUser = mUser;
        this.mPass = mPass;
    }

    @Generated(hash = 1459804235)
    public Person(Long id, UUID mID, String mUser, String mPass) {
        this.id = id;
        this.mID = mID;
        this.mUser = mUser;
        this.mPass = mPass;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

}

