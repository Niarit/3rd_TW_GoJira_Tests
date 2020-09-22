# 3rd_TW_GoJira_Tests

A testing project for the Jira software aiming to test one of it's addon called Glass and to learn the usage of the software.
Contains test written using Selenium and POM desing pattern.

This project is written so, that it can run on remote servers and can be integrated into a Jenkins pipeline.

#Glass

Glass is a Jira addon which makes project managment in Jira way more easier. The clean desing on the addon makes it much easier to see trough the given project.

![glass main page](https://i.imgur.com/a8nNhQB.png)

For those who are not familiar with the over all Jira system, Glass provides handy notes next to every main feature to make the life easier. It makes issue type, scheme, version
and component editing way faster with the easy-to-access link on the projects Glass page.

![handy notes](https://i.imgur.com/RR5JDJd.png)
![easy-to-access link](https://i.imgur.com/j2IseZh.png)


Permissions and Notifications are also became much easier to manage in this addon, using the same easy-to-access links and a nice grid style view for better understandting
and readability.

![permissions matrix](https://i.imgur.com/Km3wfoN.png)


#The project

In this project the task was to determind if the latest version of Glass is in a state to release it or not. For this Selenium, Selenium grid, POM desing pattern, Jenkins pipelines and Zalenium (remote server, for test running) was used.

![test running in Zalenium](https://i.imgur.com/NqKBfpS.png)



![Runing Jenkins build](https://i.imgur.com/2ecTvLr.png)

