# SI_2025_lab2_233092
## Стефан Анчев 233092

#### **Control Flow Graph**

[CFG link](https://www.figma.com/board/cd4zUbxi694T5Cpr2RKfwd/CFG?node-id=0-1&t=d3YfICevme3paVCm-1)

#### **Цикломатска комплексност**

V(G) = E – N + 2
Број на врски: 31
Број на јазли: 24

31 - 24 = 7
7 + 2 = 9

Според предикатни јазли:

Јазол 1, Јазол 4.2, Јазол 6, Јазол 8, Јазол 10, Јазол 13, Јазол 15.2 , Јазол 16 

8 + 1 = 9

#### **Every Statement Метод**

#### **Multiple Condition Метод**

Во условот if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
Имаме 3 подуслови и секој подуслов може да биде Точен или Неточен

Вкупно се 2^3 = 8 тест случаи


C1 = item.getPrice() > 300


C2 = item.getDiscount() > 0


C3 = item.getQuantity() > 10


|  C1 C2 C3  | Name     | Price | Discount | Quantity | Card Number  |
|------------|----------|-------|----------|----------|--------------|
|  T  T  T   | Produkt  | 500   | 0.5      | 30       | 123…16(valid)|
|  T  T  F   | Produkt  | 500   | 0.5      | 5        | 123…16(valid)|
|  T  F  T   | Produkt  | 500   | 0.0      | 30       | 123…16(valid)|
|  F  T  T   | Produkt  | 100   | 0.5      | 30       | 123…16(valid)|
|  T  F  F   | Produkt  | 500   | 0.0      | 30       | 123…16(valid)|
|  F  T  F   | Produkt  | 100   | 0.5      | 5        | 123…16(valid)|
|  F  F  T   | Produkt  | 100   | 0.0      | 30       | 123…16(valid)|
|  F  F  F   | Produkt  | 100   | 0.0      | 5        | 123…16(valid)|
