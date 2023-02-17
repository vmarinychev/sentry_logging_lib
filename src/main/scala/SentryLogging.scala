
import SentryLogger.Keys.{
  RequestId, Organization, Fingerprint
}
import io.sentry.Sentry
import org.slf4j.{LoggerFactory, MDC}

import scala.util.Random


case class SentryLogger(
  dns: String,
  frequency: Long = 1L
) {
  private val logger = LoggerFactory.getLogger(classOf[SentryLogger])

  Sentry.init(dns)

  def withFrequency(frequency: Long): SentryLogger = this.copy(frequency = frequency)

  def requestId(value: String) =  MDC.put(RequestId, s"request_id-$value")

  def organization(value: String) = MDC.put(Organization, s"organization-$value")

  def fingerprint(value: String) = MDC.put(Fingerprint, s"fingerprint-$value")


  def error(message: => String): Unit = {
    if (shouldLog) {
      logger.error(message)
    }
  }

  def info(message: => String): Unit = {
    if (shouldLog) {
      logger.info(message)
    }
  }

  def debug(message: => String): Unit = {
    if (shouldLog) {
      logger.debug(message)
    }
  }

  def warning(message: => String): Unit = {
    if (shouldLog) {
      logger.warn(message)
    }
  }

  def sentryError(message: String): Unit = {
    if (shouldLog) {
      Sentry.captureMessage(message)
    }
  }

  private def shouldLog: Boolean =
    frequency == 1L || (Random.nextInt() % frequency == 0)
}


object SentryLogger {
  object Keys {
    val RequestId = "request_id"
    val Organization = "organization"
    val Fingerprint = "fingerprint"
  }
}
