/**
 * 
 */
package com.jimmyc.tiendamusicalweb.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

/**
 * @author JimmyC
 * Clase Client de Paypal que configura las clases necesarias para 
 * realizar las transacciones hacia paypal y tambien el CLIENT ID y SECRET ID 
 * de acceso a la aplicacion de SandBox
 */

public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "ARYk9ss8CmWDc9PVL0EJDiMzj2WPXS5FWXLwquCjoW98jVKL67fAe97FXHb55Q0fuNMm0Y0pAciKyvko",
    "EPpW9ywwltQxUFqFtmjFL8td1YO1yIa7E6rVk50cLZa_kXDRMBVXzkB0qoVPIP0BJXDGpKGTdulrxqip");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}


