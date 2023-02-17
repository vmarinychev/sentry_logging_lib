import io.sentry.Sentry

object SentryLoggingProvider {
  def logger(
    dns: String
  ): SentryLogger = {

    SentryLogger(dns)
  }
}
