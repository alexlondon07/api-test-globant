package com.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAsxGZF4+h8gQQyJ+v6XYwZOB1RVGuZLJbewIIhIbYSQ1IiN5u\r\n" + 
			"fZKmW9chTwAy5WO5SmDtML2S2ODTCfK1pVS4jGhQEcSp4nV59QliCoGR2yVSrWkh\r\n" + 
			"VjlA3AGGS+pnMzzjR3TAnitTg0tyRh0T/OP47DWdNLpcJGh6TjYRfXXS7fF15ybW\r\n" + 
			"24HwCk0OgdN9p1H776b3mRLmKF8lIkv21qxqVsbfR9Y6KX/yIyl4HJETiP5eV5BI\r\n" + 
			"K1cjYL0hr8mk1aYC+ddGqi50z54k5PHrS79bKY9EIifqCHozQLVUp3IQVKkFkRqB\r\n" + 
			"23LNtEhKTQ8vQBwFTgWsl1XrDZrchJLMuK3ulQIDAQABAoIBAQCvZM1PBqDZLKJD\r\n" + 
			"4CWtxtYf+Lrk6tymRQzVr2goZuvyodAqP7R5yuqnilBV0RwJE2SqNcYdt5HeXFhZ\r\n" + 
			"piHFjvY0kPfcb4T3C5opKMefAsqanDQfJppAmlOtKtEgCriKt1jm5LTGOCnUsFF9\r\n" + 
			"2314dtOaiekxfFhEURF7CfqXqJCx/eqNmMu+nECnlAHo9aN8oKBbAT6Nb1/dOP5N\r\n" + 
			"phpn9ONU0Q7DsY9v1kbGIkAkGHHy8hwh0MCQNYGDQ1zGgUX+1+nNWvxUbS7F8Rn8\r\n" + 
			"Vni/IcXuOMyf1myXkBYv1MJFt6fwmHx4y7S3JWfRXCv6F5068UyYqCUN+vkfzzSV\r\n" + 
			"MFd1v4kBAoGBAO2Cbw/FfJC9NWu0Ct36L3Xboxfse2rMHmE3qmmaM7L+9+gP7oLP\r\n" + 
			"CwKdzpIhMpmW4Dem0jaurCssmJgKb7fMFYkb9t3ptaMbb9lXvxdkYTFiFmgoFcv6\r\n" + 
			"XsZmvIUpMFE3bPIboyNwCIfoI9sspB6nZu85+jdMPfihQFtHn1Hu9z2bAoGBAMEC\r\n" + 
			"cHdcDQhAP4rS7A06Af5PmyAwnrP43iKU+31bCeZEdPs4KLmEa4eG+mUQM0D7rEGq\r\n" + 
			"cBWxy9L341M93I5YT/6x9Qtm+XHJfk+1lmmj4VVcR11ISbV7GvzNzfyQZxV6ZLvY\r\n" + 
			"NZeUqK569j9PHJ1pbls1A89uMCp3zkzFGVTcgl+PAoGBAIOOhRAaVqYhd86hmodc\r\n" + 
			"Bh/lOdCNl8sPJyC4Ybc+x7Y1DoJHGNjx7+pSGNLOeqWica3BxJyvYgREHn3RAhKv\r\n" + 
			"g5o/mB1RT9/52Zlsxhch7cgZycmFspUaqJaC35duuimyZrEwZ8vASalmBz5m2r10\r\n" + 
			"AksuNQ+eNpFaWDh3UqNilyZTAoGAZv6CPW9llO2T+uSrCjPWNHsOcJMBXVCEWTff\r\n" + 
			"K/mUwsftFNHXCYhcSSoCHEQU1ax3M2NcBHeoKKAXMqhkNaFyrpsQBFGi8tFvEeH4\r\n" + 
			"rc7Bw+dGPcUBcFKNCDJapVf5akCx2Ht7vbOaf+El3oq83lMQjKMxsVM/aKod8GGN\r\n" + 
			"LvesqokCgYBqLCQ/wBQnfbOMbgdlibXMN0TONoo8dZgYV9f8/+jWztqC1jJhc3h9\r\n" + 
			"n24MIR/a4PHQvWEEsgWEIwhT6+4uv/FUDYoLlUPbdj6AJfcATKRhRxV5cnB6CfeR\r\n" + 
			"KXPPVnuxN7enoYEkWbBrHpsZMFcraSLM7fliDEhj9M+sc/CVab6DVw==\r\n" + 
			"-----END RSA PRIVATE KEY-----\r\n";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsxGZF4+h8gQQyJ+v6XYw\r\n" + 
			"ZOB1RVGuZLJbewIIhIbYSQ1IiN5ufZKmW9chTwAy5WO5SmDtML2S2ODTCfK1pVS4\r\n" + 
			"jGhQEcSp4nV59QliCoGR2yVSrWkhVjlA3AGGS+pnMzzjR3TAnitTg0tyRh0T/OP4\r\n" + 
			"7DWdNLpcJGh6TjYRfXXS7fF15ybW24HwCk0OgdN9p1H776b3mRLmKF8lIkv21qxq\r\n" + 
			"VsbfR9Y6KX/yIyl4HJETiP5eV5BIK1cjYL0hr8mk1aYC+ddGqi50z54k5PHrS79b\r\n" + 
			"KY9EIifqCHozQLVUp3IQVKkFkRqB23LNtEhKTQ8vQBwFTgWsl1XrDZrchJLMuK3u\r\n" + 
			"lQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----\r\n";

}
