from urllib.parse import quote_plus    # 한글 텍스트를 퍼센트 인코딩으로 변환
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait   # 해당 태그를 기다림
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException    # 태그가 없는 예외 처리
import time

url = f'https://www.melon.com/genre/song_list.htm?gnrCode=GN0900#params%5BgnrCode%5D=GN0900&params%5BdtlGnrCode%5D=GN0901&params%5BorderBy%5D=POP&params%5BsteadyYn%5D=N&po=pageObj&startIndex=1'
chromedriver = 'D:\hongikFinalProject\chromedriver_win32\chromedriver.exe'

options = webdriver.ChromeOptions()
driver = webdriver.Chrome(chromedriver, options=options)

driver.get(url)

try:
    element = WebDriverWait(driver, 5).until(
        EC.presence_of_element_located((By.CLASS_NAME, 'wrap_song_info'))
    )
    song_list = []
    singer_list = []

    song_data = driver.find_elements_by_class_name('ellipsis.rank01')
    singer_data = driver.find_elements_by_class_name('ellipsis.rank02')

    for k in song_data:
        song_list.append(k.text)

    for k in singer_data:
        singer_list.append(k.text)


except TimeoutException:
    print('해당 페이지에 곡 정보가 존재하지 않습니다.')

finally:
    driver.quit()
# for i in song_list:
 #   print(i)
