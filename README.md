Java Thread Practice

This repository contains Java examples and small projects created to practice Multithreading and Concurrency concepts.

Topics Covered

* Thread
* Runnable
* start()
* run()
* sleep()
* join()
* yield()
* Thread Priority
* synchronized
* Race Condition
* Multithreading

Projects

MultiThreadCounter

Two threads increment the same counter 1000 times.

* Uses synchronized to prevent race conditions.
* Uses join() to wait for both threads.
* Final count: 2000

CargoDistributionSystem

Simulates multiple couriers delivering packages.

* Uses Runnable
* Uses Thread.sleep()
* Uses Thread.yield()
* Demonstrates thread priorities
* Uses join() to wait for all couriers

OnlineExamSimulator

Simulates multiple students taking an online exam at the same time.

* Each student runs in a separate thread.
* sleep() simulates the time spent solving questions.
* join() waits until all students finish.

Purpose

The purpose of these projects is to understand how Java threads work and how multiple tasks can run concurrently.

Technologies

* Java
* Object-Oriented Programming
* Multithreading & Concurrency
