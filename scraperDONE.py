


from bs4 import BeautifulSoup
import requests
import pandas as pd
import csv

page = requests.get("http://schlafly.com/events/calendar/category/live-music-at-the-tap-room/?phpMyAdmin=rqakePlL%2CK9KJRAOn7E0rw9DiZ2")
page

soup = BeautifulSoup(page.content, 'html.parser')

#selects the a of h5 inside the div
bands = soup.select("div h5 a")

#selects the h3 element with the class='date'
date = soup.select("h3.date")

#creates list data of html elements as well as the venue id
data = []
for i in range(len(bands)):
	data.append([bands[i].get_text(), date[i].get_text(), 1])
print(data)

#creates and writes csv from data list
fun = pd.DataFrame(data)
fun.to_csv("shows.csv")
