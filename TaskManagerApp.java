package com.taskmanagerapp;

import java.util.Scanner;

class Task
{
	private String description;
	private boolean isCompleted;
	Task(String description)
	{
		this.description=description;
	}
	void setDescription(String description) 
	{
		this.description = description;
	}
	String getDescription()
	{
		return this.description;
	}
	boolean isCompleted() 
	{
		return this.isCompleted;
	}
	void markCompleted()
	{
		this.isCompleted=true;
	}
	public String toString() 
	{
		if(isCompleted==true)
			return description+"------ Completed";
		else
			return description+"------ Pending";
	}
}
class TaskManager
{
	Task task[];
	int taskCount=0;
	TaskManager(int initialCapacity)
	{
		task=new Task[initialCapacity];
	}
	void addTask(String description)
	{
		if(taskCount==task.length)
		{
			System.out.println("Task Limit Reached......\n Delete One Task to add New Task");
		}
		else
		{
			Task t=new Task(description);
			task[taskCount]=t;
			System.out.println("Task Added...\n");
			taskCount++;
		}
	}
	void markTaskCompleted(int index)
	{
		task[index].markCompleted();
		System.out.println(task[index]);
		System.out.println("Task Completed.....\n");
	}
	void listPendingTasks()
	{
		if(taskCount==0)
			System.out.println("No Pending Tasks...\n");
		for(int i=0;i<taskCount;i++)
		{
			if(task[i].isCompleted()==false)
			{
				System.out.println((i+1)+"-"+task[i]);
				
			}
		}
	}
	void listCompletedTasks()
	{
		if(taskCount==0)
			System.out.println("No Completed Tasks...\n");
		for(int i=0;i<taskCount;i++)
		{
			if(task[i].isCompleted()==true)
			{
				System.out.println((i+1)+"-"+task[i]);
			}
		}
	}
	void listAllTasks()
	{
		if(taskCount==0)
			System.out.println("No Tasks To Show...\n");
		for(int i=0;i<taskCount;i++)
		{
				System.out.println((i+1)+"-"+task[i]);
		}
	}
	void deleteTask(int index)
	{
		if(taskCount==0)
			System.out.println("No Tasks To Delete....\n");
		else
		{ 
			if(task[index].isCompleted()==true)
			{
				task[index].setDescription(null);
				for(int i=index;i<taskCount-1;i++) 
				{ 
					task[i]=task[i+1];
				}
				taskCount--;
			}
			else
				System.out.println("Can't Delete Pending Task....\n");
		}
	}
}
public class TaskManagerApp
{
	public static void main(String[] args) 
	{
		TaskManager tm=new TaskManager(10);
		Scanner sc=new Scanner(System.in);
		boolean isExit=false;
		while(!isExit)
		{
			System.out.println("1.Add Task");
			System.out.println("2.Mark As Complete");
			System.out.println("3.List All Tasks");
			System.out.println("4.List Completed Tasks");
			System.out.println("5.List Pending Tasks");
			System.out.println("6.Delete A Completed Task");
			System.out.println("7.Exit....");
			System.out.println("\n-----Enter An Option-----");
			int op=sc.nextInt();
			sc.nextLine();
			switch(op)
			{
				case 1: System.out.println("-----Enter Task Description-----");
						String des=sc.nextLine();
						tm.addTask(des);
						break;
				case 2: tm.listPendingTasks();
						System.out.println("-----Enter Task Id To Mark-----");
						int index=sc.nextInt();
						tm.markTaskCompleted(index-1);
						break;
				case 3: tm.listAllTasks();
						break;
				case 4: tm.listCompletedTasks();
						break;
				case 5: tm.listPendingTasks();
						break;
				case 6: tm.listAllTasks();
						System.out.println("-----Enter Task Id to Delete-----");
						int del=sc.nextInt();
						tm.deleteTask(del-1);
						break;
				case 7: isExit=true;
						System.out.println("Remember The Pending Tasks...");
						break;	
			}
		}
	}
}
