package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class GroupMembers {

    private int id;
    private int group;
    private Integer member;
    private Integer groupMember;

    public GroupMembers () {}
    public GroupMembers (int id, int group, Integer member, Integer groupMember) {
        this.id = id;
        this.group = group;
        this.member = member;
        this.groupMember = groupMember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public Integer getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Integer groupMember) {
        this.groupMember = groupMember;
    }

}
