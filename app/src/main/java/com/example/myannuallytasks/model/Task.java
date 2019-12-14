package com.example.myannuallytasks.model;

import com.example.myannuallytasks.Controller.State;
import com.example.myannuallytasks.greendao.Stateconverter;
import com.example.myannuallytasks.greendao.UuidConverter;


import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;


@Entity(nameInDb = "Task")
public class Task {

    @Id(autoincrement = true)
    private Long _id;

    @Property(nameInDb = "uuid")
    @Index(unique = true)
    @Convert(converter = UuidConverter.class, columnType = String.class)
    private UUID id;

    private long personId;
    @ToOne(joinProperty = "personId")
    private Person person;

   /* @Property(nameInDb = "id_user")
    @Index(unique = true)
    @Convert(converter = UuidConverter.class, columnType = String.class)
    private  UUID id_user;*/

    @Property(nameInDb = "title")
    String mTitle;

    @Property(nameInDb = "detaile")
    String mdetaile;


    @Property(nameInDb = "state")
    @Convert(converter = Stateconverter.class, columnType = String.class)
    State mState;


    /// @Convert(converter = dateConverter.class, columnType = Long.class)
    @Property(nameInDb = "date")
    Date mDate;


    @Property(nameInDb = "time")
    Date mTime;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1469429066)
    private transient TaskDao myDao;

    @Generated(hash = 1154009267)
    private transient Long person__resolvedKey;

    public Task(String mTitle, String mdetaile, State mState, Date mDate, Date mTime) {
        this.mTitle = mTitle;
        this.mdetaile = mdetaile;
        this.mState = mState;
        this.mDate = mDate;
        this.mTime = mTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public UUID getId() {
        return id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public State getmState() {
        return mState;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmState(State mState) {
        this.mState = mState;
    }

    public String getmdetaile() {
        return mdetaile;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmdetaile(String mdetaile) {
        this.mdetaile = mdetaile;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    /////////////////////////////
    public Task() {
        id = UUID.randomUUID();
      //  mDate = generateRandomDate();
//        mDate = new Date();  زمان همان لحطه
    }

    @Generated(hash = 269433505)
    public Task(Long _id, UUID id, long personId, String mTitle, String mdetaile,
            State mState, Date mDate, Date mTime) {
        this._id = _id;
        this.id = id;
        this.personId = personId;
        this.mTitle = mTitle;
        this.mdetaile = mdetaile;
        this.mState = mState;
        this.mDate = mDate;
        this.mTime = mTime;
    }

    

  ///////////////

    private int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMTitle() {
        return this.mTitle;
    }

    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getMdetaile() {
        return this.mdetaile;
    }

    public void setMdetaile(String mdetaile) {
        this.mdetaile = mdetaile;
    }

    public State getMState() {
        return this.mState;
    }

    public void setMState(State mState) {
        this.mState = mState;
    }

    public Date getMDate() {
        return this.mDate;
    }

    public void setMDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getMTime() {
        return this.mTime;
    }

    public void setMTime(Date mTime) {
        this.mTime = mTime;
    }

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1944524480)
    public Person getPerson() {
        long __key = this.personId;
        if (person__resolvedKey == null || !person__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PersonDao targetDao = daoSession.getPersonDao();
            Person personNew = targetDao.load(__key);
            synchronized (this) {
                person = personNew;
                person__resolvedKey = __key;
            }
        }
        return person;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1382592572)
    public void setPerson(@NotNull Person person) {
        if (person == null) {
            throw new DaoException(
                    "To-one property 'personId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.person = person;
            personId = person.getId();
            person__resolvedKey = personId;
        }
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
    @Generated(hash = 1442741304)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskDao() : null;
    }
}
