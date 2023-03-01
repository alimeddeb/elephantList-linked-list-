"""
This file serves as a medium to test the detectionm of exposed secrets in source code.
All the passwords included in this file are either dummy passwords or automatically generated and are not in use in any way whatsoever
"""

# Secrets in Variables
p1 = '4B]ghN'
p2 = '[^"{8fZmb2'
p3 = 'hunter2'
p4 = 'kennwort2023'
p5 = '!E$^hUXWECJ)YA*5T/BG'
p6 = 'myPasS1990!'
p7 = '!E$^hUXWECJ)YA*5T/BG'
p7 = 'azerty1234'
p8 = "MxPPendW0LelfpIba3xi"
P9 = ["20041970cat", "qwerty2020", "QlTatKFsb%?"]


# Encryption Keys
ecdsa_key = 'ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBN+Mh3U/3We4VYtV1QmWUFIzFLTUeegl1Ao5/QGtCRGAZn8bxX9KlCrrWISIjSYAwCajIEGSPEZwPNMBoK8XD8Q= ylo@klar'
my_key = 'MHcCAQEEIJWbvSW7h50HPwG+bWR3DXgQ6YhOxYbe0ifr1rRUvsUuoAoGCCqGSM49 AwEHoUQDQgAE34yHdT/dZ7hVi1XVCZZQUjMUtNR56CXUCjn9Aa0JEYBmfxvFf0qU KutYhIiNJgDAJqMgQZI8RnA80wGgrxcPxA=='
ssh_rsa = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC5wT7PWoFFq+k/RTJIN2mC1qcA2U+B3dThgLhvVC9CUUSDWrY1O9X7p8QijApAZkZg0h6OgcSnANF27HwEXomqVTZg6h4rOh8+NGVmKNzC4t+o62NRBis+TWJxNlwoAvE4V/+zNB3fvlcGs3/H0V4U5geL2V7QTm9lSh48PazYB/VeGDHiLyFWEZl6cV1G1pni/uCAC6GGq0GDzgfow3lm1SGtD2lJ+biafDjV1yFgzLE1TFMrhhgURzucCqif854yGGZxaudxZHZdeAbb+N8L4vOMADeNuRbRAxgj4JSuOHULfV+uRyVtOaGw37AHhERW9C2H9NYym/1iLAi1Ra99MlZIS7dKuAtWeOu/UpePzOUw5O9nabw1gklmEAoRWxoaqC74YEX7gZVg9iDNbpm+byf43A3VpEofVRWnZXaO0BjoTCwqgq+f1DZEqT7mSjVqzUJM0rr37aTiKVknRwAGae3vb0k3VfShGujK+YZOrYgNChTRIhVkBMfivX7wI2E= VW+AQBTWPZ@VWAGWOC00N37"
base64_secret = 'c1VjcmV0IG1ld3NhZ2Ugc28geW91J2xsIG5lemVyIGd1ZXNzIG25IHBhc3N3b3Lk'
hex_secret = '8b1118b376c313ed420e5133ba91307817ed52c2'
basic_auth = 'http://username:whywouldyouusehttpforpasswords@example.com'


# Access Keys
aws_access_key = 'AKIAIOSFODNN7EXAMPLE'
aws_secret_access_key = 'wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY'
google_Oauth_key = "072635-01234567890123456789abcdefghijKL.apps.googleusercontent.com"


# Secrets in a function
def foo(name, password):
    username = name 
    pwd = password
    inner_secret = "Xwf7dHEiXFsgUAotMBJe"
    return (username, pwd)

print(foo("admin", "hollowLog1970!"))


# Secret in a class
class User():
    def __init__(self, name, key):
        self.username = name
        self.secret = key
        self.inner_pass = "password0000"

    def getSecret(self):
        return self.secret

    def bar(self):
        return "MonkeyDrinkWaterOasisDesert2023"

test_user = User("user1485", "qwertz9876543210")
print(test_user.getSecret())
user_secret = test_user.bar()


# *** Secrets in comments
# k5oDtZfVMLJkiOg2FaV2
# pass1234567890
# fin5xUyx0LWM0IBO2xvX


# Secrets in docstring
"""This docstring contains a password: myp@ssword2023"""
"""AKIAIOSFODNN7EXAMPLE
o2/+wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
qwertz123456
"""
"""how about one in myPaswordS17845& the middle of a sentence and then add a fhZtJJiUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY after it
"""

# TRUE NEGATIVES: These must not be caught by the secret scanner
REGULAR_VALUE = 'this is just a long string, like any string you would find anywhere'
FOOD = 'sweet rice casserole'
ANIMAL = 'ElepHant'
red_herring = 'DEADBEEF' 
passing_wordwide = 'just a random string'
my_pw = """A harmless docstring""" 

