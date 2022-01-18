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
    lyric_list = []
    lyric_info = driver.find_elements_by_class_name(
        'btn.button_icons.type03.song_info')

    lyric_info_length = len(lyric_info)
    for index in range(lyric_info_length):
        # driver.back을 사용했을 때 DOM 갱신을 막기 위해 추가 코드 입력(for 문을 length 활용)
        lyric_click = driver.find_elements_by_class_name(
            'btn.button_icons.type03.song_info')[index]
        lyric_click.click()
        lyric_data = driver.find_element_by_class_name('lyric')
        lyric_list.append(lyric_data.text)
        driver.back()


except TimeoutException:
    print("곡 정보가 없습니다.")

finally:
    driver.quit()
