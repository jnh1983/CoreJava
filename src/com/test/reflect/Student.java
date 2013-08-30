package com.test.reflect;

public class Student
{
    private int id;
    private String name;

    public Student()
    {
    }

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Student [id=" + id + ", name=" + name + "]";
    }

    private void print(String p_msg1, String p_msg2)
    {
        if (id == 0)
        {
            System.out.println("There is no data.");
            System.out.println("The input message is " + p_msg1 + p_msg2);
        }
        else
        {
            System.out.println(toString());
        }
    }
}
