/* Copyright (c) 1996-2015, OPC Foundation. All rights reserved.
   The source code in this file is covered under a dual-license scenario:
     - RCL: for OPC Foundation members in good-standing
     - GPL V2: everybody else
   RCL license terms accompanied with this source code. See http://opcfoundation.org/License/RCL/1.00/
   GNU General Public License as published by the Free Software Foundation;
   version 2 of the License are accompanied with this source code. See http://opcfoundation.org/License/GPLv2
   This source code is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
*/
package org.opcfoundation.ua.transport.security;

import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Mac;

import org.opcfoundation.ua.common.ServiceResultException;
import org.opcfoundation.ua.transport.tcp.impl.SecurityToken;

/**
 * Crypto Provider interface for encrypting and decrypting services.
 */
public interface CryptoProvider {

	public byte[] base64Decode(String string);

	public String base64Encode(byte[] bytes);

	public Mac createMac(SecurityAlgorithm algorithm, byte[] secret)
			throws ServiceResultException;

	public int decryptAsymm(PrivateKey decryptingKey,
			SecurityAlgorithm algorithm, byte[] dataToDecrypt, byte[] output,
			int outputOffset) throws ServiceResultException;

	public int decryptSymm(SecurityToken token, byte[] dataToDecrypt,
			int inputOffset, int inputLength, byte[] output, int outputOffset)
					throws ServiceResultException;

	public void encryptAsymm(PublicKey encryptingCertificate,
			SecurityAlgorithm algorithm, byte[] dataToEncrypt, byte[] output,
			int outputOffset) throws ServiceResultException;

	public int encryptSymm(SecurityToken token, byte[] dataToEncrypt,
			int inputOffset, int inputLength, byte[] output, int outputOffset)
					throws ServiceResultException;

	public byte[] signAsymm(PrivateKey senderPrivate,
			SecurityAlgorithm algorithm, byte[] dataToSign)
					throws ServiceResultException;

	public void signSymm(SecurityToken token, byte[] input, int verifyLen,
			byte[] output) throws ServiceResultException;

	public boolean verifyAsymm(PublicKey signingCertificate,
			SecurityAlgorithm algorithm, byte[] dataToVerify, byte[] signature)
					throws ServiceResultException;

	public void verifySymm(SecurityToken token, byte[] dataToVerify,
			byte[] signature) throws ServiceResultException;

}
