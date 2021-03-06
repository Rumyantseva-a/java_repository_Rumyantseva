package rumyantseva.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void primeTest () {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void primeTestnonPrime () {
    Assert.assertFalse(Primes.isPrimeFast(Integer.MAX_VALUE - 2));
  }

  @Test (enabled = false)
  public void primeTestLong () {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }




}